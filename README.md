This is a cli tool that records transactions:

It has a Home Screen: The home screen gives the user the following options.
D) Add Deposit - prompt user for the deposit information and save it to the csv file
P) Make Payment (Debit) - prompt user for the debit information and save it to the csv file
L) Ledger - display the ledger screen
X) Exit - exit the application

It also has a Ledger Screen- All entries should show the newest entries first
A) All - Display all entries
D) Deposits - Display only the entries that are deposits into the account
P) Payments - Display only the negative entries (or payments)
R) Reports - A new screen that allows the user to run pre-defined reports or to run a custom search
    1) Month To Date
    2) Previous Month
    3) Year To Date
    4) Previous Year
    5) Search by Vendor - prompt the user for the vendor name and displays all entries for that vendor
    0) Back - go back to the report page
H) Home - go back to the home page


The data are stored in a transaction.csv that looks like this:

date|time|description|vendor|amount
2024-04-29|22:03:26|invoice 1|Joe|100.0
2024-04-29|22:04:15|keyboard|amazon|-99.0
2024-04-25|10:15:00|laptop|Best Buy|-899.99
2024-04-20|14:30:45|phone case|Apple|-29.99
2024-03-15|09:45:30|office chair|IKEA|-199.99
2024-03-12|11:20:10|lamp|Target|-49.99
2024-02-28|18:00:00|rent payment|Landlord|-1500.0
2024-02-25|08:45:00|groceries|Walmart|-75.0
2024-01-29|13:30:00|internet bill|ISP|-70.0
2024-01-22|12:00:00|car payment|Bank|-500.0
2023-12-31|23:59:59|new year's party|Friends|50.0
2023-12-30|17:30:00|electricity bill|Utility Co.|-120.0
2023-11-28|09:00:00|gifts|Amazon|-200.0
2023-11-20|10:30:00|movie tickets|Cinema|-40.0
2023-10-29|08:00:00|pet supplies|Pet Store|-35.0
2023-10-28|11:45:00|dinner|Restaurant|-60.0
2023-09-30|14:00:00|books|Bookstore|-25.0
2023-09-28|16:20:00|concert tickets|Ticketmaster|-80.0
2023-08-31|10:00:00|clothing|Fashion Store|-90.0
2023-08-29|15:45:00|coffee|Café|-5.0
