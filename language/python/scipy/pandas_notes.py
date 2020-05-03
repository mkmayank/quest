# Data Structure
#     Series      1D      contianer for scalars
#     Dataframe   2D      container for series

#         Dataframe

#         █   █   █   █  column names
#     █   ░   ░   ▓   ░
#     █   ░   ░   ▓   ░
#     █   ▓   ▓   ▓   ▓  row
#     █   ░   ░   ▓   ░
#   index        col

#     Dataframe can be though like spreadsheets


import pandas as pd
import numpy as np

# NaN (not a number) is the standard missing data marker used in pandas
np.nan

# to create series
s = pd.Series([1,2,23,3], index=list('abcd'))

# to create dataframe
df = pd.DataFrame(np.random.randint(6, size=(6,4)), index=list('arushi'), columns=list('love'))

# dtypes for DataFrame returns a Series with the data type of each column
# NumPy arrays have one dtype for the entire array
# while pandas DataFrames have one dtype per column
df.dtypes

# expensive if columns with different data types
df.to_numpy()

# to view top and bottom of dataframe
df.head()
df.tail(3)

# to get index columns
df.index
df.columns

# quick statistic summary of data
df.describe()

# to transpose
df.T

# to sort by index
df.sort_index()
# to sort by column
df.sort_index(axis=1)

# axis is 0 for index / rows
# axis is 1 for columns

# sort by values
df.sort_values(by='column_name')
# or
df.sort_values(by=['column_name_1', 'column_name_2'])

# operations returns new df object
# for inplace , use inplace=True

# selection
# select columns
df.column_name
# or
df['column_name']
# or
df[['column_name_1', 'column_name_2']]

# slicing rows
df[0:3]  # for rows 0 to 2
df['index_1': 'index2']

# selection by label
df.loc['index_name']

df.loc['index_name', 'column_name']
df.loc['index_name', ['column_name_1', 'column_name_2']]
df.loc['index_name_1':'index_name_2', ['column_name_1', 'column_name_2']]
df.loc[['index_name_1','index_name_2'], ['column_name_1', 'column_name_2']]

# for both, use df.loc
#       first_param         index or index_list ot index_slice
#       second param        column or column_list or column_slice
#
# for single, use df
#       column or column_list or index_slice

# selection via position
# same as loc but with numbers
df.iloc[3]

# for selecting all use :
df.iloc[:, 1:2]

# for getting scalar but faster
df.iat[1,1]

# boolean indexing
df[df['l'] > 3]
# for seelcting values
df[df>0]

df['m'] = list('really')
df[df['m'].isin(['r', 'e'])]


# to drop rows if it has nan
df.dropna()
# to fill value if nan is there
df.fillna(value=5)

# apllying function to data
df.apply(lambda x: x.max() - x.min())