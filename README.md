# Vending Machine Kata
###### Based on [Guy Royse's version.](https://github.com/guyroyse/vending-machine-kata)


In this exercise you will build the brains of a vending machine.  It will accept money, make change, maintain
inventory, and dispense products.  All the things that you might expect a vending machine to accomplish.

The point of this kata to to provide a larger than trivial exercise that can be used to practice TDD.  A significant
portion of the effort will be in determining what tests should be written and, more importantly, written next.

We have included the Spring Framework to allow practice of using a dependency injection framework, integration testing 
and creating a RESTful API to make requests against.

Start with simple unit tests and create classes that work together and core functionality is achieved before moving on 
to getting it to work in Spring.

Development Practices For Interview Katas
=====================
Make Frequent Commits
---------------------
Use the Red -> Green -> Refactor cycle to help drive commits.
- Pass a test -> Make a commit!
- Refactor -> Make a commit!

Use Feature Branching
---------------------
The features listed below can all be done in feature branches for git workflow practice.  Open a pull request to the 
'dev' branch when the feature is done.

Use Descriptive Commit Messages
-------------------------------
This is a good practice for interview katas, you don't want to be seen as a developer that writes "Another commit" on 
the projects third commit.  

Some tips:
- **Use multi-line commit messages with Git Bash.**  After you have entered the title of your commit, don't close the 
String, hit 'Enter/Return' twice to add a couple new lines and then you can enter comments in addition to your commit 
title. 
- **Don't know what to say? Use the test title!**  Use the test title for you commit title, but make it readable, don't 
use camel case.  Sometimes a commit won't have comments, that's ok, the first couple tests might not change much in the 
system, let the test title convey the meaning of the commit in that case.
- **"I FORGOT TO COMMIT SINCE 6 TESTS AGO!"** Better late than never!
- **Changed a bunch of stuff during refactoring?** Be specific about which files are being commited using `git add 
<filename>` instead of `git add .`.  You can add more than one file to a commit with this command.  This will allow you 
to make smaller commits and focus your commit message on those specific files.

Have a Plan
-----------
Make a plan, but keep it general.  The beautiful thing about TDD is that sometimes a more simple solution presents 
itself.

Practice OOP Principles
-----------------------
This is a great exercise for the SOLID principles of Object Orientated Programming.  Read about them and see if you can 
use them in this exercise.

Features
========

Accept Coins
------------
  
_As a vendor_  
_I want a vending machine that accepts coins_  
_So that I can collect money from the customer_  

The vending machine will accept valid coins (nickels, dimes, and quarters) and reject invalid ones (pennies).  When a
valid coin is inserted the amount of the coin will be added to the current amount and the display will be updated.
When there are no coins inserted, the machine displays INSERT COIN.  Rejected coins are placed in the coin return.

NOTE: The temptation here will be to create Coin objects that know their value.  However, this is not how a real
  vending machine works.  Instead, it identifies coins by their weight and size and then assigns a value to what
  was inserted.  You will need to do something similar.  This can be simulated using strings, constants, enums,
  symbols, or something of that nature.
  
  NOTE's Note: There has been some argument in our organization about whether or not this is worthy of your time, I 
  (Ben) think there is value to using a String and having the Vending Machine assign a value to that String.  I have 
  spent hours in the rabbit hole of what a coin is, when in reality, a String would have been just as good. 

Select Product
--------------

_As a vendor_  
_I want customers to select products_  
_So that I can give them an incentive to put money in the machine_  

There are three products: cola for $1.00, chips for $0.50, and candy for $0.65.  When the respective button is pressed
and enough money has been inserted, the product is dispensed and the machine displays THANK YOU.  If the display is
checked again, it will display INSERT COIN and the current amount will be set to $0.00.  If there is not enough money
inserted then the machine displays PRICE and the price of the item and subsequent checks of the display will display
either INSERT COIN or the current amount as appropriate.

Make Change
-----------

_As a vendor_  
_I want customers to receive correct change_  
_So that they will use the vending machine again_  

When a product is selected that costs less than the amount of money in the machine, then the remaining amount is placed
in the coin return.

Return Coins
------------

_As a customer_  
_I want to have my money returned_  
_So that I can change my mind about buying stuff from the vending machine_  

When the return coins button is pressed, the money the customer has placed in the machine is returned and the display shows
INSERT COIN.

Sold Out
--------

_As a customer_  
_I want to be told when the item I have selected is not available_  
_So that I can select another item_  

When the item selected by the customer is out of stock, the machine displays SOLD OUT.  If the display is checked again,
it will display the amount of money remaining in the machine or INSERT COIN if there is no money in the machine.

Exact Change Only
-----------------

_As a customer_  
_I want to be told when exact change is required_  
_So that I can determine if I can buy something with the money I have before inserting it_  

When the machine is not able to make change with the money in the machine for any of the items that it sells, it will
display EXACT CHANGE ONLY instead of INSERT COIN.

BONUS FEATURES
==============
API Requests
------------

_As a Game Dev,_
_I want to be able to use this software across the web,_
_So that I can create a client for users to interact with._

Create a controller that interacts with a VendingMachine object and receives and sends information about the state of 
application via HTTP.

Additional Features
-------------------

_As a Player,_
_I want to control more of the machine's state,_
_So that I can simulate being a vending machine servicer._

- [ ] Create a way to empty and reset the machine's cash.
- [ ] Create a way to restock the goods in the machine. 
- [ ] Create a way to replace the item offered in a slot of the machine's offerings.