/*
 * Copyright (c) 2013 Noveo Group
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
 * Except as contained in this notice, the name(s) of the above copyright holders
 * shall not be used in advertising or otherwise to promote the sale, use or
 * other dealings in this Software without prior written authorization.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.noveogroup.android.task;

import java.util.Collection;
import java.util.List;

public interface TaskExecutor {

    /**
     * Returns synchronization object of this {@link TaskExecutor}.
     * <p/>
     * Any access to this {@link TaskExecutor} should be synchronized using
     * this object.
     * <p/>
     * The same object should be returned from method {@link Pack#lock()} by
     * all of collections of arguments associated with tasks belonging to
     * this {@link TaskExecutor}.
     *
     * @return the synchronization object.
     */
    public Object lock();

    public <Input, Output> Pack<Input, Output> newPack();

    public <Input, Output> Pack<Input, Output> newPack(Pack pack);

    public Pack<Void, Void> args();

    public TaskSet queue(String... tags);

    public TaskSet queue(Collection<String> tags);

    public TaskSet queue(Collection<String> tags, Collection<TaskHandler.State> states);

    public ErrorHandler getErrorHandler();

    public void setErrorHandler(ErrorHandler errorHandler);

    public void addTaskListener(TaskListener<Object, Object> taskListener);

    public void removeTaskListener(TaskListener<Object, Object> taskListener);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, String... tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Collection<String> tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, TaskListener<Input, Output> taskListener, String... tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, TaskListener<Input, Output> taskListener, Collection<String> tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, List<TaskListener<Input, Output>> taskListeners, String... tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, List<TaskListener<Input, Output>> taskListeners, Collection<String> tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Input input, String... tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Input input, Collection<String> tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Input input, TaskListener<Input, Output> taskListener, String... tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Input input, TaskListener<Input, Output> taskListener, Collection<String> tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Input input, List<TaskListener<Input, Output>> taskListeners, String... tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Input input, List<TaskListener<Input, Output>> taskListeners, Collection<String> tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Pack<Input, Output> vars, String... tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Pack<Input, Output> vars, Collection<String> tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Pack<Input, Output> vars, TaskListener<Input, Output> taskListener, String... tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Pack<Input, Output> vars, TaskListener<Input, Output> taskListener, Collection<String> tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Pack<Input, Output> vars, List<TaskListener<Input, Output>> taskListeners, String... tags);

    public <Input, Output> TaskHandler<Input, Output> execute(Task<Input, Output> task, Pack<Input, Output> vars, List<TaskListener<Input, Output>> taskListeners, Collection<String> tags);

    public void shutdown();

    public boolean isShutdown();

}
