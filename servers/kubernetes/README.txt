Kubernetes (K8s)    -   open-source system for automating deployment, scaling and management of containers across clusters of hosts

Minikube    -   tool to makes easy to run Kubernetes locally
            -   runs a single-node Kubernetes cluster inside a VM

kubectl     -   command line interface for running commands against Kubernetes clusters

kubelet     -


pod
    -   smallest deployable units of computing that can be created and managed in Kubernetes
    -   group of one or more containers with shared storage/network, and a specification for how to run the containers tightly coupled — in a pre-container world
    -   one pod lies on one node (machine) only

deployments
events

=====================

    Master: The machine that controls Kubernetes nodes. This is where all task assignments originate.

    Node: These machines perform the requested, assigned tasks. The Kubernetes master controls them.

    Pod: A group of one or more containers deployed to a single node. All containers in a pod share an IP address, IPC, hostname, and other resources. Pods abstract network and storage away from the underlying container. This lets you move containers around the cluster more easily.

    Replication controller:  This controls how many identical copies of a pod should be running somewhere on the cluster.

    Service: This decouples work definitions from the pods. Kubernetes service proxies automatically get service requests to the right pod—no matter where it moves to in the cluster or even if it’s been replaced.

    Kubelet: This service runs on nodes and reads the container manifests and ensures the defined containers are started and running.

    kubectl: This is the command line configuration tool for Kubernetes
