
##### Installation
[https://bokeh.pydata.org/en/latest/docs/user_guide/quickstart.html#userguide-quickstart](https://bokeh.pydata.org/en/latest/docs/user_guide/quickstart.html#userguide-quickstart)

1. Install conda :
    ```bash
    $ # Download https://docs.conda.io/en/latest/miniconda.html
    $ # install
    $ bash Miniconda3-latest-Linux-x86_64.sh
    ```

2. Install bokeh

    ```bash
    $ conda install bokeh
    ```

----

##### Run

```python
from bokeh.plotting import figure, output_file, show

# prepare some data
x = [1, 2, 3, 4, 5]
y = [6, 7, 2, 4, 5]

# output to static HTML file
output_file("lines.html")

# create a new plot with a title and axis labels
p = figure(title="simple line example", x_axis_label='x', y_axis_label='y')

# add a line renderer with legend and line thickness
p.line(x, y, legend="Temp.", line_width=2)

# show the results
show(p)

```

* it will create a html file which can be open on browser


##### Steps

1. Prepare some data

2. Tell Bokeh where to generate output
    `output_file()` or `output_notebook()` for use in Jupyter notebooks.

3. Call `figure()`
This creates a plot with typical default options and easy customization of title, tools, and axes labels.

4. Add renderers

5. Ask Bokeh to `show()` or `save()` the results.
    These functions save the plot to an HTML file and optionally display it in a browser.


##### WebGl

* Enable webgl in borwser, disabled by default
    Chrome : chrome://flags/
    seacrh for webgl and enable it

##### Datashader & HoloView
    ```bash
    $ conda install datashader
    ```