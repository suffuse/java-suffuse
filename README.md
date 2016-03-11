java-suffuse
------------

[![Build Status](https://travis-ci.org/suffuse/java-suffuse.svg?branch=master)](https://travis-ci.org/suffuse/java-suffuse)

Skeletal framework for generating FUSE bindings with [BridJ](https://github.com/nativelibs4java/BridJ).

OSX only at the moment. You may have to install [osxfuse from github](https://github.com/osxfuse/osxfuse/releases) and not from brew cask.

```
% sbt test
Auto-configuring parser...
Parsing native headers...
Normalizing parsed code...
Generating libraries...
[...]
Generating fuse_operations.java
Generating fuse_context.java
Generating fuse_module.java
Generating OsxfuseLibrary.java
#
# SUCCESS: JNAeration completed !
#
[info] Test suffuse.tests.SmokeTest.mkdirTest started
[info] Test suffuse.tests.SmokeTest.statTest started
// size = 80, alignment = 8
struct struct_stat {
  @Field(0) int st_dev; // offset = 0, length = 4, alignment = 4
  @Field(1) short st_mode; // offset = 4, length = 2, alignment = 2
  ...
  @Field(12) int st_lspare; // offset = 60, length = 4, alignment = 4
  @Field(13) Pointer<Long> st_qspare;
}
/var/folders/gw/_2jq29095y7b__wtby9dg_5h0000gn/T/suffuse4158558868993322369
struct_stat {
  st_dev = 16777218;
  st_mode = 4070;
  ...
  st_gen = ?;
  st_qspare = ?;
}
[success] Total time: 40 s, completed Mar 11, 2016 8:19:30 AM
```
