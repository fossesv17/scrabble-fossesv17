# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

## Sumary
	
The objective of this project is to recreate a simplified version of Scratch developed by 
[_Scratch Foundation_] (https://scratch.mit.edu/). The idea is to be able to create a programming enviroment where
the user can create applications without needing knowledge on programming languages. The project will be developed in Java.

## Getting Started

Following the instructions of this repository will get you a copy of the project so you can 
run and test in your personal machine

## Prerequisites

-Java 11 or superior recommended
-JUnit 5 or superior for testing
-Intellij IDE to work and launch
-Gradle Build Tools

## Installing and Running tests
Cloning the repository or downloading the zip file with the content will get you a copy of the project.
Then opening it with Intellij and executing Gradle Build task will run all tests.

## Data types

For this project we will work with 3 basic types of data: _Strings_, _Booleans_ and _Numbers_
where numbers will be subdivided in: _floats_, _integers_ and _binaries_.

## Work

The project is structured in partial progressive assignments and that's how it will be documented for revision.

### 1st assignment

The first assignments was to implement the types system for Scrabble using Java native types to emulate their behauvior.
This way get a Java class for every type to be implemented and every one of these classes have their main value 
represented with a Java native as shown here:

-ScrabbleBool represented by a _Java_ Bool
-ScrabbleString represented by a _Java_ String
-ScrabbleFloat represented by a _Java_ double
-ScrabbleInt represented by a _Java_ int
-ScrabbleBinary represented by a _Java_ String of bits

Once we had Scrabble types the next step was to implement transformation operations for every Scrabble type following
a table that indicated which transformation was valid or not.

At this stage of the project, everything was implemented using Java Intefaces to group types in a convenient way.

### 2nd assignment  
For this next stage we had to implement operation betweeen Scrabble types. For this almost everything was acomplished
by making use of double dispatch and returning according to the indications for which operations where valid and returning
<null> for those that weren't

Aside from this the only assumption that was made was that since String can concatenate with everything but only when the operation
is done with an String on the left, the operations _Addition_ and _Concatenation_ were separated. Different to 
how originally was indicated in the instructions. leaving _concatenation_ to be implemented by itself but be applicated on
every type as long as an ScrabbleString makes the call on other types, not the other way around.

### Note

The project has been developed to this point for now waiting for further instructions to continue working on it. 

### 3rd assignment
For this stage the objective was to represent operations as trees that contained Scrabble types as arguments for every operation.
Every operation was successfully implemented this way except for transformations on tree nodes for now

### 4th assignment
(WIP)
For the 4th assignment the idea was to implement a system to declare and save variables with the purpose of saving memory
this is yet to be implemented