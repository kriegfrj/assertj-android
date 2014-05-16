package org.fest.assertions.api.android.app;

import android.app.Notification;

/**
 * Assertions for {@link Notification} instances.
 * <p/>
 * This class is final. To extend use {@link AbstractNotificationAssert}.
 */
public final class NotificationAssert extends AbstractNotificationAssert<NotificationAssert, Notification> {
  public NotificationAssert(Notification actual) {
    super(actual, NotificationAssert.class);
  }
}
