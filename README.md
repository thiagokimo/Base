# Base

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Base-green.svg?style=flat)](https://android-arsenal.com/details/1/2454)
![Jitpack Badge](http://img.shields.io/github/release/thiagokimo/Base.svg?label=JitPack)

Base is a lightweight library that gives you a clean architecture foundation for your Android MVP's.

![icon](https://raw.githubusercontent.com/thiagokimo/Base/master/images/base-icon.png)

The main objective of this repository is to show developers
how I would architect my Android code in future projects.

For more details of this library, click [here](http://kimo.io/2015/09/06/base/).

## Using

Add it in your build.gradle at the end of repositories:
``` groovy
repositories {
	// ...
	maven { url "https://jitpack.io" }
}
```

Add the base into your dependencies:

``` groovy
dependencies {
    // base files
    compile 'com.github.thiagokimo.Base:base:1.3.0'
}
```

Base can be used with the support libraries as well:
``` groovy
// support v4
compile 'com.github.thiagokimo.Base:base-v4:1.3.0'
```
``` groovy
// support v7
compile 'com.github.thiagokimo.Base:base-v7:1.3.0'
```

## Credits
- Icon by Jhun Capaya

## License

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
