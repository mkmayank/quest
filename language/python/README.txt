Install miniconda to create own environment


wget https://repo.anaconda.com/miniconda/Miniconda3-latest-Linux-x86_64.sh
bash Miniconda3-latest-Linux-x86_64.sh

Activate conda environment

source .bashrc

Create python2 environment

conda create -n py2 python=2

Create python3 environment

conda create -n py3 python=3

Activate desired environment
conda activate py3

Install notebook and kernel

conda install notebook ipykernel
ipython kernel install --user

Run jupyter notebook
jupyter notebook --no-browser --port=8800 --ip=0.0.0.0

Connect via ssh port forwarding
ssh -N -f -L localhost:8888:localhost:8800 dev

