# Oracle repository for leiningen

A Leiningen plugin for connecting to the oracle maven repository.

[Oracle maven repository][oracle-repository] contains oracle closed source components e.g. oracle jdbc drivers.

The problem of this repository is that
 - It requires authentication using OTN user account
 - The authentication is implemented using Oracle Access Management product (OAM)
 
Oracle calls this enterprise-grade SSO solution, which actually means unnecessary complicated bullshit.

The authentication requires special tweaks to HTTPWagon see <http://docs.oracle.com/middleware/1213/core/MAVEN/config_maven_repo.htm#MAVEN9015>.

This leiningen plugin provides a special repository protocol `oam11g`. 
This protocol uses a configured HTTPWagon, which can access to the oracle repository.

## Usage

You have to be familiar with basic concepts in [leiningen].

Add this plugin (definition below) into the project `:plugins` vector.

[![Clojars Project](http://clojars.org/lein-oracle-repository/latest-version.svg)](http://clojars.org/lein-oracle-repository)

Add oracle repository definition: `["oracle" {:url "oam11g://maven.oracle.com"}]` 
into the project `:repositories` vector. 

Add OTN account authentication information i.e. a user name and a password. 
The simplest option is to add this information in plain text to `~/.lein/profiles.clj` e.g.

`{:auth {:repository-auth {#"oracle" {:username "scott"
                                      :password "tiger"}}}}`

All possible options (e.g. encryption) are defined in <https://github.com/technomancy/leiningen/blob/stable/doc/DEPLOY.md#authentication>

Instructions to OTN account registration can be found from [here][oracle-repository].

Note: you cannot load leiningen plugins from the oracle repository 
if these plugins are defined in the same `:plugins` vector as this plugin.

## License

Copyright © 2017 Mika

Distributed under the Eclipse Public License version 1.0.

[oracle-repository]: https://maven.oracle.com/
[leiningen]: https://leiningen.org/
