# Mockserver

## Description

Python implementation using micro framework Flask.
Introduce the 4 plain routes with json response.
Integrate a basic Authentication with the token/ route and a
401/Unauthorized access when token is missing.
Use a ssl adhoc system.

Provide a Makefile with an easy setup :
- virtualenv for development ;
- docker container for deployment.

Add minimal documentation (function doctstrings).
Main issues fixed with pylint.

## Getting started

```
make
```

The command create a docker image and run a containerized mockserver.

## Help

```
make help
```

## Configuration

The default configuration `scenarios/default.json`, provides the canonical success complete case.
For a more special use case, create or edit a json file in the directory `scenarios/`.
To run the mockserver under this configuration, set the argument CONFIG with the filename:

```
# build an image
make image
```

```
# run a container
make run CONFIG=filename
```

```
# build an image
# run a container
make CONFIG=filename
```

## Virtual environment

It is recommended to use the docker container just for a "stable" version.
For development, a virtual environement is the better choice.

### Create a virtual environment
```
make virtualenv
```
The command above :

- install the package `virtualenv`
- create a virtual environment `venv` (`venv/` directory)

### **Activate** the environment

Activate the environment when it is created.
```
source venv/bin/activate
```

### Dependencies

Install the requirements inside the virtual environment :
```
pip install -r requirements.txt
```

### Run the application

```
./api.py
```
This setup support a hot reload making work and test easier.

### Exit venv

```
deactivate
```

## Update `requirements.txt` ?

### Freeze all dependencies (**`/!\`** not recommended)

```
pip freeze > requirements.txt
```

May introduce conflictuals dependencies hard linked to a specific system.

### Retrieve only project dependencies

```
pipreqs --force .
```

> **`/!\`** Make sure 'cryptography==2.8' is in requirements.txt !
