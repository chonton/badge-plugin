/*
 * The MIT License
 *
 * Copyright (c) 2025, Badge Plugin Authors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.jenkinsci.plugins.badge.action;

import hudson.model.BuildBadgeAction;
import java.io.Serial;
import org.jenkinsci.plugins.scriptsecurity.sandbox.whitelists.Whitelisted;
import org.kohsuke.stapler.export.Exported;

/**
 * Common action for badges.
 */
public class BadgeAction extends AbstractBadgeAction implements BuildBadgeAction {

    private String target;

    @Serial
    private static final long serialVersionUID = 1L;

    public BadgeAction(String id, String icon, String text, String cssClass, String style, String link, String target) {
        super(id, icon, text, cssClass, style, link);
        this.target = target;
    }

    @Whitelisted
    public void setTarget(String target) {
        this.target = target;
    }

    @Exported
    @Whitelisted
    public String getTarget() {
        return target;
    }

    @Override
    public String getDisplayName() {
        return "Badge Action";
    }
}
