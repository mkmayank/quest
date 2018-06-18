Ansible by default manages machines over the SSH protocol

Ansible has host key checking enabled by default.
it can be turned off :
    host_key_checking = False
    Alternatively this can be set by the ANSIBLE_HOST_KEY_CHECKING environment variable:
    $ export ANSIBLE_HOST_KEY_CHECKING=False


By default, Ansible will try to use native OpenSSH for remote communication when possible. This enables ControlPersist (a performance feature), Kerberos, and options in ~/.ssh/config such as Jump Host setup
On old system, (without ControlPersist) Ansible will fallback into using a high-quality Python implementation of OpenSSH called ‘paramiko’


==============================================

Cmd line tools
    ansible             -   Define and run a single task ‘playbook’ against a set of hosts
    ansible-config      -   View, edit, and manage ansible configuration
    ansible-console     -   REPL console for executing Ansible tasks.
    ansible-doc         -   plugin documentation tool
    ansible-galaxy      -   manage Ansible roles in shared repostories, the default of which is Ansible Galaxy https://galaxy.ansible.com. / to use community ansible playbooks
    ansible-inventory   -   used to display or dump the configured inventory as Ansible sees it
    ansible-playbook    -   to run Ansible playbooks
    ansible-pull        -   pulls playbooks from a VCS repo and executes them for the local host
                        -   inverts the default push architecture of ansible into a pull architecture
    ansible-vault       -   encryption/decryption utility for Ansible data files
                            password used with vault currently must be the same for all files you wish to use together at the same time

all are symlink to ansible python script
