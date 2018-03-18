image
    -   a read-only template with instructions for creating a Docker container

$ docker build -t <IMAGE_TAG> .                 # Create image using this directory's Dockerfile
$ docker run -d -p 4000:80 friendlyhello        # Run "friendlyname" mapping port 4000 to 80
$ docker image ls -a                            # List all images on this machine
$ docker login                                  # Log in this CLI session using your Docker credentials
$ docker tag <image> username/repository:tag    # Tag <image> for upload to registry
$ docker push username/repository:tag           # Upload tagged image to registry
$ docker run username/repository:tag            # Run image from a registry
