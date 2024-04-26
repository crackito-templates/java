# Java Maven Template

The following guide will explain the different elements you need to know to use the crackito platform on a java project using maven.

## Summary

-   [Maven project structure](#maven-project-structure)
-   [Naming convention](#file-naming)
-   [.protected file](#file-protection)

## Maven project structure

A maven project follows [these principles][maven project layout].

For our example, we will keep only the following ones

| Name                        | Path            |
| --------------------------- | --------------- |
| Application/Library sources | `src/main/java` |
| Test sources                | `src/test/java` |

All your application's source code will be in one folder, and tests in another.

You don't have to put all your .java code in the root of `src/main/java`, maven will automatically look at all the files and sub-folders in `src/main/java`. The same goes for tests.

## File naming

We've just said that you don't have to put all your files in the `src/test/java` root, but to allow better test management at crackito level, we'll put all the files in the root, named as follows:

-   Exercise1Test.java
-   Exercise2Test.java

The file name must respect this regex `Exercise\d{1,}Test.java`

## File protection

Now that you have your source code and all the tests for all the exercises, it would be a good idea to prevent them from being modified, either intentionally or unintentionally.

That's where the `.protected` file comes in. It allows you to set certain files to read-only by specifying the file path.

If you want to block `Exercise1Test.java` in `src/test/java`, you can simply write `src/test/java/Exercise1Test.java` in the `.protected` file.


You can also block all .java in `src/test/java` with the following line `src/test/java/*.java`.

If you wish to completely disable the editing/creation of .java in the `src/test/java` folder, you can do the following
```
src/test/java/**/*.java
src/test/java/*.java
```

**🚨 Warning 🚨** Only one rule per line is required in the `.protected` file.

<!-- URL -->

[maven project layout]: https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html
