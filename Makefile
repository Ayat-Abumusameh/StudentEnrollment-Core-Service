# Makefile it's to simplify Docker Compose workflow commands (Make it easy)

run:
    docker-compose up --build

stop:
	docker-compose down

clean:
	docker-compose down -v
