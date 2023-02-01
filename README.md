# Random User(s) with VueJS + Vite + Java Springboot REST API

A VueJS + Java Springboot API app that demonstrates

- Java Springboot REST API
- Simple VueJS Web app
- Integration with randomuser.me/api endpoint
- TailwindCSS styling
- Multistage Docker builds

## Prerequisite

Please have the following installed:

| Ref                          | Url                                                 |
| ---------------------------- | --------------------------------------------------- |
| Node LTS (use nvm) Linux/Mac | https://github.com/nvm-sh/nvm/releases.             |
| Node LTS (use nvm) Windows   | https://github.com/coreybutler/nvm-windows/releases |
| docker                       | https://docs.docker.com/install/                    |

NOTE: for Windows users, please use a terminal that supports Linux commands. Here are a few
| App | Url|
|---| ---|
|Cmder | https://cmder.net/|
|Windows Subsystem|https://docs.microsoft.com/en-us/windows/wsl/install-win10|

## Getting Started

## Build + Deployment

A Docker-Compose file is included, run:

```
docker-compose build
docker-compose up
```
Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.


## Services

| Service | Url                                                   | Description              |
| ------- | ----------------------------------------------------- | ------------------------ |
| api     | http://localhost:5000/user?count=<int>&nat=<au,us,fr> | Java Springboot REST API|
| web     | http://localhost:3000                                 | Web front end            |


## NOTE
- CORS is activated as web and api are hosted on different ports. In the Springboot UserController, a CorsOrigin whitelist is added to allow traffic from the web app
```
    @CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
    })
```