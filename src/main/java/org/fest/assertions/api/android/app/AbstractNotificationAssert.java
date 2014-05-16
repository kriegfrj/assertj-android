package org.fest.assertions.api.android.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.net.Uri;

import org.fest.assertions.api.AbstractAssert;
import org.fest.assertions.api.android.util.BitMaskStringBuilder;

import static android.app.Notification.FLAG_AUTO_CANCEL;
import static android.app.Notification.FLAG_FOREGROUND_SERVICE;
import static android.app.Notification.FLAG_HIGH_PRIORITY;
import static android.app.Notification.FLAG_INSISTENT;
import static android.app.Notification.FLAG_NO_CLEAR;
import static android.app.Notification.FLAG_ONGOING_EVENT;
import static android.app.Notification.FLAG_ONLY_ALERT_ONCE;
import static android.app.Notification.FLAG_SHOW_LIGHTS;
import static android.app.Notification.PRIORITY_DEFAULT;
import static android.app.Notification.PRIORITY_HIGH;
import static android.app.Notification.PRIORITY_LOW;
import static android.app.Notification.PRIORITY_MAX;
import static android.app.Notification.PRIORITY_MIN;
import static org.fest.assertions.api.Assertions.assertThat;

public abstract class AbstractNotificationAssert<S extends AbstractNotificationAssert<S, A>, A extends Notification> extends AbstractAssert<S, A> {
  public AbstractNotificationAssert(A actual, Class<S> selfType) {
    super(actual, selfType);
    as("notification");
  }

  public S hasContentIntent(PendingIntent intent) {
    isNotNull();
    assertThat(actual.contentIntent)
      .as(getWritableAssertionInfo().description() + ".contentIntent")
      .isEqualTo(intent);
    return myself;
  }

  public S hasDefaults(int defaults) {
    isNotNull();
    int actualDefaults = actual.defaults;
    assertThat(actualDefaults) //
        .overridingErrorMessage("[%s] Expected defaults <%s> but was <%s>.",
              getWritableAssertionInfo().description(), defaults, actualDefaults) //
        .isEqualTo(defaults);
    return myself;
  }

  public S hasDeleteIntent(PendingIntent intent) {
    isNotNull();
    assertThat(actual.deleteIntent)
      .as(getWritableAssertionInfo().description() + ".deleteIntent")
      .isEqualTo(intent);
    return myself;
  }

  public S hasFlags(int flags) {
    isNotNull();
    int actualFlags = actual.flags;
    assertThat(actualFlags) //
        .overridingErrorMessage("[%s] Expected flags <%s> but was <%s>.",
            getWritableAssertionInfo().description(),
            flagsToString(flags),
            flagsToString(actualFlags)) //
        .isEqualTo(flags);
    return myself;
  }

  public S hasFlag(int flag) {
    isNotNull();
    assertThat(actual.flags & flag)
      .overridingErrorMessage("[%s] Expected to have flag <%s> but didn't.",
          getWritableAssertionInfo().description(),
          flagsToString(flag))
      .isNotZero();
    return myself;
  }
  
  public S doesNotHaveFlag(int flag) {
    isNotNull();
    assertThat(actual.flags & flag)
      .overridingErrorMessage("[%s] Expected to not have flag <%s> but did.",
          getWritableAssertionInfo().description(),
          flagsToString(flag))
      .isZero();
    return myself;
  }

  public S isAutoCancel() {
    return hasFlag(FLAG_AUTO_CANCEL);
  }
  
  public S isNotAutoCancel() {
    return doesNotHaveFlag(FLAG_AUTO_CANCEL);
  }

  public S isForegroundService() {
    return hasFlag(FLAG_FOREGROUND_SERVICE);
  }
  
  public S isNotForegroundService() {
    return doesNotHaveFlag(FLAG_FOREGROUND_SERVICE);
  }
  
  public S isInsistent() {
    return hasFlag(FLAG_INSISTENT);
  }
  
  public S isNotInsistent() {
    return doesNotHaveFlag(FLAG_INSISTENT);
  }
  
  public S canBeCleared() {
    return doesNotHaveFlag(FLAG_NO_CLEAR);
  }
  
  public S cantBeCleared() {
    return hasFlag(FLAG_NO_CLEAR);
  }
  
  public S isOngoing() {
    return hasFlag(FLAG_ONGOING_EVENT);
  }
  
  public S isNotOngoing() {
    return doesNotHaveFlag(FLAG_ONGOING_EVENT);
  }
  
  public S onlyAlertsOnce() {
    return hasFlag(FLAG_ONLY_ALERT_ONCE);
  }
  
  public S doesntOnlyAlertOnce() {
    return doesNotHaveFlag(FLAG_ONLY_ALERT_ONCE);
  }
  
  public S showsLights() {
    return hasFlag(FLAG_SHOW_LIGHTS);
  }
  
  public S doesntShowLights() {
    return doesNotHaveFlag(FLAG_SHOW_LIGHTS);
  }

  public S hasFullScreenIntent(PendingIntent intent) {
    isNotNull();
    assertThat(actual.fullScreenIntent)
      .as(getWritableAssertionInfo().description() + ".fullScreenIntent")
      .isEqualTo(intent);
    return myself;
  }

  public S hasIcon(int resId) {
    isNotNull();
    int actualId = actual.icon;
    assertThat(actualId) //
        .overridingErrorMessage("[%s] Expected icon with ID <%s> but was <%s>.",
            getWritableAssertionInfo().description(),
            resId, actualId) //
        .isEqualTo(resId);
    return myself;
  }

  public S hasIconLevel(int level) {
    isNotNull();
    int actualLevel = actual.iconLevel;
    assertThat(actualLevel) //
        .overridingErrorMessage("[%s] Expected icon level <%s> but was <%s>.",
            getWritableAssertionInfo().description(),
            level, actualLevel) //
        .isEqualTo(level);
    return myself;
  }

  public S hasLargeIcon(Bitmap bitmap) {
    isNotNull();
    assertThat(actual.largeIcon)
      .as(getWritableAssertionInfo().description() + ".bitmap")
      .isEqualTo(bitmap);
    return myself;
  }

  public S hasLedColor(int color) {
    isNotNull();
    int actualColor = actual.ledARGB;
    assertThat(actualColor) //
        .overridingErrorMessage("[%s] Expected LED color <%s> but was <%s>.",
            getWritableAssertionInfo().description(),
            Integer.toHexString(color),
            Integer.toHexString(actualColor)) //
        .isEqualTo(color);
    return myself;
  }

  public S hasLedOffMs(int length) {
    isNotNull();
    int actualLength = actual.ledOffMS;
    assertThat(actualLength) //
        .overridingErrorMessage("[%s] Expected LED off time (ms) <%s> but was <%s>.",
            getWritableAssertionInfo().description(),
            length,
            actualLength) //
        .isEqualTo(length);
    return myself;
  }

  public S hasLedOnMs(int length) {
    isNotNull();
    int actualLength = actual.ledOnMS;
    assertThat(actualLength) //
        .overridingErrorMessage("[%s] Expected LED on time (ms) <%s> but was <%s>.",
            getWritableAssertionInfo().description(),
            length,
            actualLength) //
        .isEqualTo(length);
    return myself;
  }

  public S hasNumber(int number) {
    isNotNull();
    int actualNumber = actual.number;
    assertThat(actualNumber) //
        .overridingErrorMessage("[%s] Expected number <%s> but was <%s>.",
            getWritableAssertionInfo().description(),
            number, actualNumber) //
        .isEqualTo(number);
    return myself;
  }

  public S hasPriority(int priority) {
    isNotNull();
    int actualPriority = actual.priority;
    assertThat(actualPriority) //
        .overridingErrorMessage("[%s] Expected priority <%s> but was <%s>.",
            getWritableAssertionInfo().description(),
            priorityToString(priority),
            priorityToString(actualPriority)) //
        .isEqualTo(priority);
    return myself;
  }

  public S hasSound(Uri sound) {
	isNotNull();
	assertThat(actual.sound).as(getWritableAssertionInfo().description() + ".sound").isEqualTo(sound);
	return myself;
  }

  public S hasTickerText(CharSequence text) {
    isNotNull();
    assertThat(actual.tickerText).as(getWritableAssertionInfo().description() + ".tickerText").isEqualTo(text);
    return myself;
  }

  public S hasVibration(long[] vibration) {
    isNotNull();
    assertThat(actual.vibrate).as(getWritableAssertionInfo().description() + ".vibration").isEqualTo(vibration);
    return myself;
  }

  public S hasWhen(long when) {
    isNotNull();
    long actualWhen = actual.when;
    assertThat(actualWhen) //
        .overridingErrorMessage("[%s] Expected when <%s> but was <%s>.",
            getWritableAssertionInfo().description(),
            when, actualWhen) //
        .isEqualTo(when);
    return myself;
  }

  private static String flagsToString(int flags) {
    return new BitMaskStringBuilder(flags) //
        .flag(FLAG_AUTO_CANCEL, "autoCancel")
        .flag(FLAG_FOREGROUND_SERVICE, "foregroundService")
        .flag(FLAG_INSISTENT, "insistent")
        .flag(FLAG_NO_CLEAR, "noClear")
        .flag(FLAG_ONGOING_EVENT, "ongoingEvent")
        .flag(FLAG_ONLY_ALERT_ONCE, "onlyAlertOnce")
        .flag(FLAG_SHOW_LIGHTS, "showLights")
        .flag(FLAG_HIGH_PRIORITY, "highPriority")
        .get();
  }

  private static String priorityToString(int priority) {
    switch (priority) {
      case PRIORITY_MIN:
        return "min";
      case PRIORITY_LOW:
        return "low";
      case PRIORITY_DEFAULT:
        return "default";
      case PRIORITY_HIGH:
        return "high";
      case PRIORITY_MAX:
        return "max";
      default:
        throw new IllegalArgumentException("Unknown priority: " + priority);
    }
  }
}
