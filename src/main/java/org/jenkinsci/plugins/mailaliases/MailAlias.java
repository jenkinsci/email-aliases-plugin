package org.jenkinsci.plugins.mailaliases;

import com.google.common.base.Objects;
import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundConstructor;

import javax.annotation.Nonnull;

public final class MailAlias extends AbstractDescribableImpl<MailAlias> {
    private final String email;

    @DataBoundConstructor
    public MailAlias(@Nonnull String email) {
        this.email = StringUtils.trimToEmpty(email);
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAlias mailAlias = (MailAlias) o;
        return Objects.equal(email, mailAlias.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<MailAlias> {

        @Override
        public String getDisplayName() {
            return "Additional identity";
        }
    }
}
