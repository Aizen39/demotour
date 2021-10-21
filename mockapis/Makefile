SHELL:= 		/bin/bash
CONFIG :=		default
CONTAINER = 		mockserver
IMAGE = 		mock_api_connect_of:latest

default: image run

##
##Develop
##-------
virtualenv:## create a virtual environment for development
virtualenv:
	@pip install virtualenv
	@virtualenv venv
	@echo "Activate the virtual env : source venv/bin/activate"

##
##Deploy
##------
image:## build a docker image
image:
	@docker build -t $(IMAGE) .

run:## create and start a container with $CONFIG env
run: 
	@docker run --rm -p 5000:5000 -e MOCK_CONFIG=$(CONFIG) --name $(CONTAINER) $(IMAGE)

##
##Miscellaneous
##-------------
help:
	@fgrep -h "##" $(MAKEFILE_LIST) | fgrep -v fgrep | sed -e 's/\\$$//' | sed -e 's/##//'

.PHONY: default help \
	virtualenv requirements \
	image run
