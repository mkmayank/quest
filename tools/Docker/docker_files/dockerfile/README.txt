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
        -   pipe |
                -   to fail piped command due to an error at any stage in the pipe prepend set -o pipefail
                    e.g.
                        RUN set -o pipefail && wget -O - https://some.site | wc -l > /number

                    reason :
                    Docker executes commands using the /bin/sh -c interpreter
                    which only evaluates the exit code of the last operation in the pipe to determine success

    -   EXPOSE  -   should use the common, traditional port

    -   prefer COPY over ADD
    -   using ADD to fetch packages from remote URLs is strongly discouraged; use curl or wget instead
        Reason, we can delete the files we not needed

    -   Avoid installing or using sudo since it has unpredictable TTY and signal-forwarding behavior
    -   to reduce layers and complexity, avoid switching USER back and forth frequently

    -   For clarity and reliability, always use absolute paths for your WORKDIR
