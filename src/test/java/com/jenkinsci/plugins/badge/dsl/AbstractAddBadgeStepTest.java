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
package com.jenkinsci.plugins.badge.dsl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;

@WithJenkins
abstract class AbstractAddBadgeStepTest {

    protected static JenkinsRule r;

    @BeforeAll
    static void setUp(JenkinsRule rule) {
        r = rule;
    }

    @Test
    abstract void defaultConstructor();

    @Test
    void id() {
        AbstractAddBadgeStep step = createStep(null, "icon", "text", "cssClass", "style", "link", "target");
        assertNull(step.getId());

        step = createStep("id", "icon", "text", "cssClass", "style", "link", "target");
        assertEquals("id", step.getId());

        step = createStep("", "icon", "text", "cssClass", "style", "link", "target");
        assertEquals("", step.getId());
    }

    @Test
    void icon() {
        AbstractAddBadgeStep step = createStep("id", null, "text", "cssClass", "style", "link", "target");
        assertNull(step.getIcon());

        step.setIcon("");
        assertEquals("", step.getIcon());

        step.setIcon("icon");
        assertEquals("icon", step.getIcon());
    }

    @Test
    void text() {
        AbstractAddBadgeStep step = createStep("id", "icon", null, "cssClass", "style", "link", "target");
        assertNull(step.getText());

        step.setText("");
        assertEquals("", step.getText());

        step.setText("text");
        assertEquals("text", step.getText());
    }

    @Test
    void cssClass() {
        AbstractAddBadgeStep step = createStep("id", "icon", "text", null, "style", "link", "target");
        assertNull(step.getCssClass());

        step.setCssClass("");
        assertEquals("", step.getCssClass());

        step.setCssClass("cssClass");
        assertEquals("cssClass", step.getCssClass());
    }

    @Test
    void style() {
        AbstractAddBadgeStep step = createStep("id", "icon", "text", "cssClass", null, "link", "target");
        assertNull(step.getStyle());

        step.setStyle("");
        assertEquals("", step.getStyle());

        step.setStyle("style");
        assertEquals("style", step.getStyle());
    }

    @Test
    void link() {
        AbstractAddBadgeStep step = createStep("id", "icon", "text", "cssClass", "style", null, "target");
        assertNull(step.getLink());

        step.setLink("");
        assertEquals("", step.getLink());

        step.setLink("link");
        assertEquals("link", step.getLink());
    }

    @Test
    void target() {
        AbstractAddBadgeStep step = createStep("id", "icon", "text", "cssClass", "style", "link", null);
        assertNull(step.getTarget());

        step.setTarget("");
        assertEquals("", step.getTarget());

        step.setTarget("target");
        assertEquals("target", step.getTarget());
    }

    @Test
    void string() {
        AbstractAddBadgeStep step = createStep("id", "icon", "text", "cssClass", "style", "link", "target");
        assertNotNull(step.toString());
        assertTrue(step.toString().startsWith(step.getDescriptor().getFunctionName()));

        step = createStep(null, null, null, null, null, null, null);
        assertNotNull(step.toString());
        assertEquals(step.getDescriptor().getFunctionName() + "()", step.toString());
    }

    protected abstract AbstractAddBadgeStep createStep(
            String id, String icon, String text, String cssClass, String style, String link, String target);
}
