from pylib.data_process.plotter import Plotter
import pandas as pd
import numpy as np

b = Plotter(basenames = 'SBIN,SBIN_FUT',
               date = '20190913',
               sep_scales = True,
               book_depth = 10,
               top_size = [10, 10],
               models = ['MID', 'MID'],
               output_file = '/tmp/try.html',
               plot_trades = True,
               start_time = '035000',
               end_time = '095900')

b.get_books()
b.get_trades()
b.mark_base_prices()

p = b.plot_markets()

from bokeh.plotting import output_notebook, show, figure

output_notebook()
p.background_fill_color = "black"
p.plot_height = 400
p.plot_width = 800
show(p)