# importing date class from datetime module
from datetime import date
  
# creating the date object of today's date
todays_date = date.today()
name= input("Enter yor name : ")
age=input("Enter your age : ")
x=todays_date.year+(100-int(age))

txt="{}  will be 100 years at the year {}"
print(txt.format(name,x))