# 3-SAT-Generator
Generates a 3-sat instance. Will eventually be part of a larger project; will be used to help generate Mario levels. 

Essentially a single function. The generator will prompt the user for an m (number of clauses) and a n (number of variables), and then will generate a single 3-SAT instance that has the correct number of clauses and number of variables.

The generator is functional, and will also include a test to see if the instance is solvable. 

The test is the simple exponential solution, but that is acceptable for these purposes. It only has to generate the instances a single time, so speed is not essential. The time required to generate the levels could be optimized in later work, but need not be for this experiment. 

The instance that is generated is in the form of a string, which is a little annoying to deal with, but in other ways is helpful. I think I'll have to add a new class for instance so that it's not in the form of a string, and instead it has a toString method. That way, I can easily get the benefits of the string form without the detriments, though it will require a significant rework.

