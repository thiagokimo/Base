#Base

![Jitpack Badge](https://img.shields.io/github/release/thiagokimo/Base.svg?label=JitPack)

Base is a lightweight library that gives you a clean architecture foundation for your Android MVP's.

![icon](https://raw.githubusercontent.com/thiagokimo/Base/master/images/base-icon.png)

The main objective of this repository is to show developers
how I would architect my Android code in future projects.

![diagram](http://kimo.io/images/android-diagram.png)

For more details of this library, click [here](http://kimo.io/2015/09/06/base/).

## Using

Add it in your build.gradle at the end of repositories:
``` groovy
repositories {
	    // ...
	    maven { url "https://jitpack.io" }
}
```

Add any of the modules inside your dependencies:

``` groovy
dependencies {
    // base files
    compile 'com.github.thiagokimo.Base:base:1.0.0'
    // support v7
    compile 'com.github.thiagokimo.Base:base-v7:1.0.0'
    // mvp module
    compile 'com.github.thiagokimo.Base:base-mvp:1.0.0'
    // domain base files
    compile 'com.github.thiagokimo.Base:base-domain:1.0.0'
}
```

## Credits
- Icon by Jhun Capaya

##License

    Copyright 2011, 2012 Thiago Rocha

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
