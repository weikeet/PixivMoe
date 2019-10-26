package me.weicools.pixivmoe.lib.integration.lifecycle

import com.trello.rxlifecycle3.android.ActivityEvent
import com.trello.rxlifecycle3.android.FragmentEvent
import io.reactivex.subjects.Subject

/**
 * @author Weicools Create on 2019.10.22
 *
 * desc:
 */
interface LifecycleSupport<E> {
  fun provideLifecycleSubject(): Subject<E>
}

interface ActivityLifecycleSupport : LifecycleSupport<ActivityEvent> {}

interface FragmentLifecycleSupport : LifecycleSupport<FragmentEvent> {}