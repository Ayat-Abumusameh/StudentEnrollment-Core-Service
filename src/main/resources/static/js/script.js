document.addEventListener("DOMContentLoaded", function () {
    // Fetch data immediately when the page opens (bring data immediately ...)
    loadEnrollments();

    // Bind buttons directly to functions based on the IDs in your HTML code
    document.getElementById("btnAdd").addEventListener("click", addEnrollment);
    document.getElementById("btnUpdate").addEventListener("click", updateEnrollment);
    document.getElementById("btnDelete").addEventListener("click", deleteEnrollment);
    document.getElementById("btnRefresh").addEventListener("click", loadEnrollments);
});

// 1- Fetch data and display it in the table.
function loadEnrollments() {
    fetch('/api/enrollments')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById("enrollmentTableBody");
            tableBody.innerHTML = ""; //Clean up old experimental lines

            data.forEach(enroll => {
                const row = `
                    <tr onclick="selectRow(${enroll.enrollmentId}, ${enroll.studentId}, ${enroll.courseId}, '${enroll.enrollmentDate}')" style="cursor:pointer;">
                        <td>${enroll.enrollmentId}</td>
                        <td>${enroll.studentId}</td>
                        <td>${enroll.courseId}</td>
                        <td>${enroll.enrollmentDate}</td>
                    </tr>
                `;
                tableBody.innerHTML += row;
            });
        })
        .catch(error => console.error('Error loading data:', error));
}

// 2-  Function to add a new record (Add button)
function addEnrollment() {
    const studentId = document.getElementById("studentId").value;
    const courseId = document.getElementById("courseId").value;
    const enrollmentDate = document.getElementById("enrollmentDate").value;

    if (!studentId || !courseId || !enrollmentDate) {
        alert("Please fill out all fields firstً!");
        return;
    }

    const enrollmentData = {
        studentId: parseInt(studentId),
        courseId: parseInt(courseId),
        enrollmentDate: enrollmentDate
    };

    fetch('/api/enrollments', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(enrollmentData)
    })
    .then(response => {
        if (response.ok) {
            alert('Saved to the database successfully!');
            clearInputs();
            loadEnrollments();
        }
    });
}

// 3- Function to edit the record (Update button)
function updateEnrollment() {
    const id = document.getElementById("enrollmentId").value;
    const studentId = document.getElementById("studentId").value;
    const courseId = document.getElementById("courseId").value;
    const enrollmentDate = document.getElementById("enrollmentDate").value;

    if (!id) {
        alert("Please click on any row in the table first to select it before editing!");
        return;
    }

    const enrollmentData = {
        studentId: parseInt(studentId),
        courseId: parseInt(courseId),
        enrollmentDate: enrollmentDate
    };

    fetch(`/api/enrollments/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(enrollmentData)
    })
    .then(response => {
        if (response.ok) {
            alert('Data updated successfully!');
            clearInputs();
            loadEnrollments();
        }
    });
}

// Function to delete the selected record (Delete button)
function deleteEnrollment() {
    const id = document.getElementById("enrollmentId").value;

    if (!id) {
        alert("Please click on the row you want to delete from the table first!");
        return;
    }

    if (confirm("Are you sure you want to permanently delete this record?")) {
        fetch(`/api/enrollments/${id}`, { method: 'DELETE' })
        .then(response => {
            if (response.ok) {
                alert("Deleted successfully!");
                clearInputs();
                loadEnrollments();
            }
        });
    }
}

// Clicking any table row automatically populates the input fields for editing or deleting
function selectRow(id, studentId, courseId, date) {
    document.getElementById("enrollmentId").value = id;
    document.getElementById("studentId").value = studentId;
    document.getElementById("courseId").value = courseId;
    document.getElementById("enrollmentDate").value = date;
}

// Clear input fields
function clearInputs() {
    document.getElementById("enrollmentId").value = "";
    document.getElementById("studentId").value = "";
    document.getElementById("courseId").value = "";
    document.getElementById("enrollmentDate").value = "";
}