/*
 *
 *  Copyright(c) 2019 VerstSiu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.ijoic.messagechannel

import java.util.logging.Logger

/**
 * Channel
 *
 * @author verstsiu created at 2019-10-15 18:51
 */
abstract class Channel {
  /**
   * Message callback
   */
  var onMessage: ((Long, Any) -> Unit)? = null

  /**
   * Error callback
   */
  var onError: ((Throwable) -> Unit)? = null

  /**
   * Prepare channel
   */
  abstract fun prepare()

  /**
   * Refresh connection
   */
  abstract fun refresh()

  /**
   * Close channel
   */
  abstract fun close()

  /**
   * Log info [message]
   */
  protected fun logInfo(message: String) {
    logger.fine("[$this] $message")
  }

  companion object {
    private val logger = Logger.getLogger(Channel::class.java.name)
  }
}