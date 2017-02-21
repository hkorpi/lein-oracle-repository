package org.apache.maven.wagon.providers.oam;

import org.apache.commons.lang.SerializationUtils;
import org.apache.maven.wagon.ConnectionException;
import org.apache.maven.wagon.authentication.AuthenticationException;
import org.apache.maven.wagon.authentication.AuthenticationInfo;
import org.apache.maven.wagon.providers.http.HttpWagon;
import org.apache.maven.wagon.proxy.ProxyInfoProvider;
import org.apache.maven.wagon.repository.Repository;

/**
 * This is same as http wagon except the repository
 * protocol is changed to https.
 */
public class OAMWagon extends HttpWagon {

    private final String oamProtocol;

    public OAMWagon(String oamProtocol) {
        this.oamProtocol = oamProtocol;
    }

    @Override
    public void connect(Repository source, AuthenticationInfo authenticationInfo, ProxyInfoProvider proxyInfoProvider )
            throws ConnectionException, AuthenticationException {

        if(source == null) {
            throw new NullPointerException("The repository cannot be null.");
        }

        super.connect(replaceProtocol(source, oamProtocol,"https"),
                authenticationInfo, proxyInfoProvider);
    }

    private static Repository replaceProtocol(Repository repository, String oldProtocol, String protocol) {
        if (repository.getProtocol().equals(protocol)) {
            return repository;
        } else {
            Repository result = (Repository) SerializationUtils.clone(repository);
            result.setUrl(repository.getUrl().replace(oldProtocol, protocol));
            //System.out.println(result);
            return result;
        }
    }
}
