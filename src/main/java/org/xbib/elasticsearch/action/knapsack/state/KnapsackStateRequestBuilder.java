/*
 * Copyright (C) 2014 Jörg Prante
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xbib.elasticsearch.action.knapsack.state;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.support.single.custom.SingleCustomOperationRequestBuilder;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.internal.InternalIndicesAdminClient;

import java.nio.file.Path;

public class KnapsackStateRequestBuilder extends SingleCustomOperationRequestBuilder<KnapsackStateRequest, KnapsackStateResponse, KnapsackStateRequestBuilder> {

    public KnapsackStateRequestBuilder(IndicesAdminClient client) {
        super((InternalIndicesAdminClient)client, new KnapsackStateRequest());
    }

    public KnapsackStateRequestBuilder setPath(Path path) {
        request.setPath(path);
        return this;
    }

    @Override
    protected void doExecute(ActionListener<KnapsackStateResponse> listener) {
        ((IndicesAdminClient)client).execute(KnapsackStateAction.INSTANCE, request, listener);
    }
}
