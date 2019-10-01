import bokeh.plotting as b
import bokeh.io

# prepare some data
x = [1, 2, 3, 4, 5]
y = [6, 7, 2, 4, 5]

# output to static HTML file
b.output_file("helloworld.html")

# create a new plot with a title and axis labels
p = b.figure(title="simple line example", x_axis_label='x', y_axis_label='y')

# add a line renderer with legend and line thickness
p.line(x, y, legend="Temp.", line_width=2)

# show the results
b.show(p)
bokeh.io.export_png(p)
