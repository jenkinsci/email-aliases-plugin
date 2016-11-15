package org.jenkinsci.plugins.emailaliases;

import com.google.common.base.Objects;
import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundConstructor;

import javax.annotation.Nonnull;

public final class EmailAlias extends AbstractDescribableImpl<EmailAlias> {
    private final String email;

    @DataBoundConstructor
    public EmailAlias(@Nonnull String email) {
        this.email = StringUtils.trimToEmpty(email);
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAlias emailAlias = (EmailAlias) o;
        return Objects.equal(email, emailAlias.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<EmailAlias> {

        @Override
        public String getDisplayName() {
            return "Additional identity";
        }
    }
}
