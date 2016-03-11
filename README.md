Skeletal framework for generating FUSE bindings with [BridJ](https://github.com/nativelibs4java/BridJ).

OSX only at the moment. You may have to install [osxfuse from github](https://github.com/osxfuse/osxfuse/releases) and not from brew cask.

```
% sbt test
Auto-configuring parser...
Parsing native headers...
/usr/include/sys/cdefs.h:74:25: warning: #warning "Unsupported compiler detected"
Normalizing parsed code...
Generating libraries...
Generating ostat.java
Generating stat.java
Generating stat64.java
Generating kevent.java
Generating kevent64_s.java
Generating klist.java
Generating itimerval.java
Generating timezone.java
Generating clockinfo.java
Generating fuse_opt.java
Generating fuse_args.java
Generating fuse_file_info.java
Generating fuse_conn_info.java
Generating flock.java
Generating flocktimeout.java
Generating radvisory.java
Generating fcodeblobs.java
Generating fsignatures.java
Generating fstore.java
Generating fbootstraptransfer.java
Generating log2phys.java
Generating statvfs.java
Generating fuse_operations.java
Generating fuse_context.java
Generating fuse_module.java
Generating OsxfuseLibrary.java
#
# SUCCESS: JNAeration completed !
# Output mode is 'Directory(Bindings sources in simple file hierarchy)
#
# => '/g/java-suffuse/target/scala-2.11/src_managed/main/c'
#
[info] Compiling 1 Scala source and 26 Java sources to /g/java-suffuse/target/scala-2.11/classes...
[info] Compiling 1 Scala source to /g/java-suffuse/target/scala-2.11/test-classes...
[info] Test run started
[info] Test suffuse.tests.SmokeTest.makeDirectory started
[info] Test run finished: 0 failed, 0 ignored, 1 total, 0.104s
[info] Passed: Total 1, Failed 0, Errors 0, Passed 1
[success] Total time: 6 s, completed 18-Jul-2015 17:41:38
```
