##Anagrams in a Dictionary
The program allows to find anagrams of a given word in the dictionary
--------------------------------------------------------------------------------------------
**Author**
Name: Jaydeep Digambar Ingle<br/>
Email: jingle1@binghamton.edu<br/>

--------------------------------------------------------------------------------------------
**Description:**
- ```Part1```</br>
This part consists of messy code. No modularization.

- ```Part2```</br>
Code is divided into functions such as <br/>
```getFileReader()```<br/>
```loadDictionary()```<br/>
```searchAnagrams()```<br/>

--------------------------------------------------------------------------------------------
**Steps:**

```$javac AnagramFinder.java```</br>
- Compiles and generates the bytecode.</br>

```$java AnagramFinder dictionary.txt```</br>
- Starts the AnagramFinder and loads the dictionary
--------------------------------------------------------------------------------------------
**Sample Output:**
```
$ java AnagramFinder dictionary.txt
Welcome to the Anagram Finder
-----------------------------
Dictionary loaded in 749 ms


AnagramFinder>stop
4 Anagrams found for stop in 0 ms
post,spot,stop,tops

AnagramFinder>sam
3 Anagrams found for sam in 0 ms
mas,sam,sma

AnagramFinder>accept
No anagrams found for accept in 0 ms


AnagramFinder>random
2 Anagrams found for random in 0 ms
random,rodman

AnagramFinder>exit


```
--------------------------------------------------------------------------------------------
