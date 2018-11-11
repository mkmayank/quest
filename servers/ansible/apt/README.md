### What is ansible ??

* Ansible is a `yaml` based framework to write tasks to perform on infrastructure in the form of playbook which can be repeated to make easy push.
* It can be thought as advance `dsh`( distributed shell ) like tool
* Ansible by default manages machines over the SSH protocol
* By default, Ansible will try to use native OpenSSH for remote communication when possible. This enables ControlPersist (a performance feature), Kerberos, and options in ~/.ssh/config such as Jump Host setup
* On old system, (without ControlPersist) Ansible will fallback into using a high-quality Python implementation of OpenSSH called ‘paramiko’
* ansible can work in both mode push or pull, but in apt , we are using push mode, as it is easy to setup and have no dependency.

### What is required to work with ansible ??

* to use ansible
    * ansible client to be installed on machine to be used to run ansible command
    * user with ssh access on the machines to be configured by ansible to user who gonna run ansible


* ansible can be run by any user, as long as above conditions are met

* ansible can be installed via repository,

  On debian or debian based system like ubuntu , use
  ```bash
$ sudo apt-get install ansible -y
  ```

  On RHEL and CentOS, use
  ```bash
$ sudo yum install ansible
    ```
fetch more info here : [link to ansible official installation guide](https://docs.ansible.com/ansible/latest/installation_guide/intro_installation.html)

apt related details :

* Ansible repo: [http://bitbucket.aptportfolio.com/projects/INFRA/repos/ansible_repo/browse](http://bitbucket.aptportfolio.com/projects/INFRA/repos/ansible_repo/browse)

* `ansible.aptportfolio.com` is configured in nspawn-container on `n09-09.ndc.aptportfolio.com` or `admin.aptportfolio.com` and it can be used directly to work with ansible, by login as `ansible_usr` on it

* some playbooks will fail, if user don't have sudo access on machines
