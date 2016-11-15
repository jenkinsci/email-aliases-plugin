package org.jenkinsci.plugins.emailaliases;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import hudson.Extension;
import hudson.model.User;
import hudson.model.UserProperty;
import hudson.model.UserPropertyDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;

import java.util.List;
import java.util.Set;

public class EmailAliasesUserProperty extends UserProperty {
    private Set<EmailAlias> emailAliases;

    @DataBoundConstructor
    public EmailAliasesUserProperty(List<EmailAlias> emailAliases) {
        this.emailAliases = emailAliases != null ? Sets.newHashSet(emailAliases) : Sets.<EmailAlias>newHashSet();
    }

    public void add(EmailAlias emailAlias) {
        emailAliases.add(emailAlias);
    }

    public void remove(EmailAlias emailAlias) {
        emailAliases.remove(emailAlias);
    }

    public Set<EmailAlias> getEmailAliases() {
        return ImmutableSet.copyOf(emailAliases);
    }

    @Extension
    public static class DescriptorImpl extends UserPropertyDescriptor {

        @Override
        public UserProperty newInstance(User user) {
            return null;
        }

        @Override
        public String getDisplayName() {
            return "E-mail aliases";
        }
    }
}
