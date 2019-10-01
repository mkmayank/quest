> datashader is designed to "rasterize" or "aggregate" datasets into regular grids that can be viewed as images, making it simple and quick to see the properties and patterns of your data. Datashader can plot a billion points in a second or so on a 16GB laptop, and scales up easily to out-of-core or distributed processing for even larger datasets.


```bash
    $ conda install datashader
    $ datashader examples $ downloads examples
    $ cd datashader-examples/data/
```
> ipython

```python
import datashader as ds
import pandas as pd
from colorcet import fire
from datashader import transfer_functions as tf

df = pd.read_csv('nyc_taxi.csv', usecols=['dropoff_x', 'dropoff_y'])
df.head()

agg = ds.Canvas().points(df, 'dropoff_x', 'dropoff_y')

image = tf.set_background(tf.shade(agg, cmap=fire),"black")

ds.utils.export_image(img=image,filename='image', fmt=".png", background=None)
```

```bash
    $ conda install holoviews
    $ conda install geoviews
```

```python
import holoviews as hv
import geoviews as gv
from holoviews.operation.datashader import datashade
hv.extension('bokeh')

url = 'https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{Z}/{Y}/{X}.jpg'
tile_opts  = dict(width=1000,height=600,xaxis=None,yaxis=None,bgcolor='black',show_grid=False)
map_tiles  = gv.WMTS(url).opts(style=dict(alpha=0.5), plot=tile_opts)
points     = hv.Points(df, ['dropoff_x', 'dropoff_y'])
taxi_trips = datashade(points, x_sampling=1, y_sampling=1, cmap=fire, width=1000, height=600)

map_tiles * taxi_trips
```


----

##### Pipeline
> Datashader provides a flexible series of processing stages that map from raw data into viewable images

Breaking up the computations in this way is what makes Datashader able to handle arbitrarily large datasets, because only one stage (Aggregation) requires access to the entire dataset. The remaining stages use a fixed-sized data structure regardless of the input dataset, allowing you to use any visualization or embedding methods you prefer without running into performance limitations.

1. Projection
2. Aggregation
3. Transformation
4. Colormapping
5. Embedding