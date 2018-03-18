Dockerfile
    -   defines what goes on in the environment inside container

========================
    -   In Docker 1.10 and higher, only RUN, COPY, and ADD instructions create layers
    -   Docker 17.05 and higher add support for multi-stage builds, copy only the artifacts needed in the final image

========================

Best practices :
    -   Use a .dockerignore file
    -   Use multi-stage builds
    -   Avoid installing unnecessary packages
    -   Each container should have only one concern
    -   Minimize the number of layers
    -   Sort multi-line arguments
    -   Build cache ( by default )

    -   use current Official Repositories as the basis for image
            Alpine image (currently under 5 mb) [recommended linux]

    -   add labels to images

    -   RUN
        -   split long or complex RUN statements on multiple lines separated with backslashes
        -   APT-GET
                -   avoid RUN apt-get upgrade or dist-upgrade
                -   update only particular package
                -   clean the apt cache rm -rf /var/lib/apt/lists/*
