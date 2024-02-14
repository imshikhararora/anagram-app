# Anagram-App
This application runs on Java backend and checks if the entered texts through CLI are anagrams or not.

## Features
- Checks if two texts are anagrams of each other.
- Out of all inputs to feature #1: provides all the anagrams for a given string.
---
- Based on definition on [Wikipedia](https://en.wikipedia.org/wiki/Anagram), while checking anagrams, spaces and special characters and cases are ignored.

## Functionality of Features in detail
### Feature #1
- Given two strings A and B as input
- A and B can have multiple words with spaces or special characters
- The program should return if these strings are anagrams or not (case insensitive, ignore spaces and special characters)

### For feature #2:
- Given these hypothetical invocations of the feature#1 function
> f1(A, B), f1(A, C), f1 (A, D)
- *IF* A, B and D are anagrams
    - f2(A) should return [B, D]
    - f2(B) should return [A, D]
    - f2(C) should return []

## Prerequisites
- [Java JDK](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)

