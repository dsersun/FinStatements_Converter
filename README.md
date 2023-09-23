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

### Table for financial statements, MySQL!
```mysql-sql
CREATE TABLE `finstatements` (
  `id` int NOT NULL AUTO_INCREMENT,
  `present_time` datetime NOT NULL,
  `denumire` varchar(80) NOT NULL,
  `cod_fiscal` varchar(13) NOT NULL,
  `report_date` varchar(20) NOT NULL,
  `active_imobilizate` double DEFAULT '0',
  `active_circulante` double DEFAULT '0',
  `capital_propriu` double DEFAULT '0',
  `DTL` double DEFAULT '0',
  `DTS` double DEFAULT '0',
  `provizioane` double DEFAULT '0',
  PRIMARY KEY (`id`)
```

