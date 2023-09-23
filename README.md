# 💡Financial Statement Converter.
### From *.xlsx file to MySQL database and JSON backup  🛠️

This service provides for the automated processing of Excel files with financial statements.
The main purpose is to extract the necessary data from the excel file and save it in the database.
In parallel, in order not to store excel files (they have a larger size), their conversion to JSON is provided, 
and xlsx files are deleted.
By default, the application after startup scans the special directory every 30 seconds, and the software stops working 
after 5 minutes. In production, however, these settings can be modified.

The structure of the database for functional testing does not provide for the saving of many balance positions. 
In the production version, these fields will be expanded.
It is also planned to automatically calculate certain indicators from the balance sheet data.

