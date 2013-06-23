/*
 * Copyright 2013 Expedia, Inc. All rights reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.epam.cache.controller;

import com.epam.cache.service.GrabberService;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Illya Yalovyy
 * @author Yaroslav Mykhaylov
 */
@Controller
@RequestMapping(value = "/service")
public class CacheControllerRest {

    private static final Logger logger =
            Logger.getLogger(CacheControllerRest.class);
    @Autowired
    private GrabberService grabberService;

    @RequestMapping(value = "/get/{schemaNameAndTableName}/{keyName}/{valueName}",
            method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getData(@PathVariable String schemaNameAndTableName,
            @PathVariable String keyName, @PathVariable String valueName) {


        return grabberService.getData(schemaNameAndTableName, keyName, valueName);
    }
}
