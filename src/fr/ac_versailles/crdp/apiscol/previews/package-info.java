/*
 * Copyright 2006 Web Cohesion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 * <p>
 * This API is a low-level utility aimed to generate web-compliant format of files for preview in browsers.
 * At this time it offers conversion services for PDF, video and current office documents formatx (.doc, .ppt, .odt, .pptx, etc.)
 * 
 * 
 * 
 *  </p><ol>
 *  <li>Video files are converted into html5 friendly formats using ffmpeg (webm, mp4 and ogv).</li>
 *  <li>Office documents are</li>
 *  <li>Indexation and full-text search</li>
 *  </ol>
 *  <section class="attention">
 *  <h2>Apiscol Content web service and download links</h2>
 *  <p>
 *  File download requests are not supported by the Apiscol Content
 *  web service. Please pay attention to the difference between the
 *  <em>/content/resource</em> path which requests the service to
 *  perform a treatment and the <em>/content/resources</em> which
 *  points to the <em>resources</em> directory in order to dowload
 *  files as static contents.
 *  </p>
 *  </section>
 */

package fr.ac_versailles.crdp.apiscol.previews;