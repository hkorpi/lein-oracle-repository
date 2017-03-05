# Change Log
All notable changes to this project will be documented in this file. 

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased]

## [0.1.0] - 2017-03-05
### Added
- First release
- Support for Oracle Access Management 11g

### Tested
 - Windows 10 (Leiningen 2.7.1 on Java 1.8.0_111)
 - Ubuntu 16.04.1 LTS (Leiningen 2.7.1 on Java 1.8.0_121)
 
### Known issues
 - You cannot load leiningen plugins from the oracle repository if these plugins are defined in the same `:plugins` vector as this plugin.
 - Downloading artifacts causes warnings about invalid cookie headers e.g.
 
        WARNING: Invalid cookie header: "Set-Cookie: IntradocAuth=Basic; path=/; Expires=Sun, 04 Mar 2018 16:57:26 GMT; HttpOnly". Invalid 'expires' attribute: Sun, 04 Mar 2018 16:57:26 GMT

[Unreleased]: https://github.com/hkorpi/lein-oracle-repository/compare/0.1.0...HEAD
[0.1.0]: https://github.com/hkorpi/lein-oracle-repository/tree/0.1.0
