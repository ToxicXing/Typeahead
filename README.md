# Typeahead
This is a simple version of typeahead implemeted in java using Trie.
## What is typeahead?
Typeahead is a feature of software, website or application(and some typewriters) that enables users to continue typing and keep receiving hottest keyowrds based on what they are typing as the prefix of those keyowrds.
## What can it do?
This version of typeahead supports build, search, serialization and deserialization.
### Build
Build method is called to build a Trie based on what we got from original data, which could be tens of thounsand items of data logs from some search engine.
Usually, the log looks like:<br>
KEYWORD  |  FREQUENCY <br>
&nbsp;&nbsp;apple &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 10 <br>
&nbsp;&nbsp;amazon &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15 <br>
&nbsp;&nbsp;intel &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4 <br>
&nbsp;&nbsp;cisco &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 13 <br>
&nbsp;&nbsp;app &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;25<br>
&nbsp;&nbsp;walmart &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;14 <br>
&nbsp;&nbsp;apex &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10 <br>
&nbsp;&nbsp;adobe &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;24 <br>
&nbsp;&nbsp;alibaba &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;32 <br>
Keyword is the top K hottest keywords that is searched in a regular period of time.<br>
Frequency is how many times a keyowrd is searched.<br>
This simple version of typeahead converted above log information into a trie.
### Search
Search will return a list of hottest keyowrds that users may want to type.
### Serialization and Deserialization
Serialization and deserialization is used to store/recover trie into/from file and disk.
