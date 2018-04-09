# Calculator
Attempt to develop a cross-platform calculator model utilizing a view interface and integrated commands.

Currently model is a go. Should have no problem adding new functonalities as elements. 
Elements are leaf components of the composite design structure.
Recently employed spring to inject the view. Autowired to my heart's content but I expect to modify the setup 
since I want the commands decoupled from the view and ready to be called upon(recoupled?). 

Created new branch that is a class library of master branch without a user interface (no view or event listeners).
Unfortunately spring is not implemented. A setter was created for the view in the Facade class to be called by the implementor of the library in his/her main class.
