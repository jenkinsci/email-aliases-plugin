package org.jenkinsci.plugins.mailaliases;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import hudson.Extension;
import hudson.model.User;
import hudson.model.UserProperty;
import hudson.model.UserPropertyDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MailAliasesUserProperty extends UserProperty {
    private Set<MailAlias> mailAliases;

    @DataBoundConstructor
    public MailAliasesUserProperty(List<MailAlias> mailAliases) {
        this.mailAliases = mailAliases != null ? Sets.newHashSet(mailAliases) : Sets.<MailAlias>newHashSet();
    }

    public void add(MailAlias mailAlias) {
        mailAliases.add(mailAlias);
    }

    public void remove(MailAlias mailAlias) {
        mailAliases.remove(mailAlias);
    }

    public Set<MailAlias> getMailAliases() {
        return ImmutableSet.copyOf(mailAliases);
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
