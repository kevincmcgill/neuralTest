babe = read.csv("babe.csv")
babe = data.matrix(babe)

set.seed(1)
Train.sample = sample(1:nrow(babe), nrow(babe)*0.8, replace = FALSE)
Train.X = babe[Train.sample,-ncol(babe)]
Train.Y = babe[Train.sample,ncol(babe)]
Test.X = babe[-Train.sample,-ncol(babe)]
Test.Y = babe[-Train.sample,ncol(babe)]

dim(babe)

library(mxnet)

data <- mx.symbol.Variable("data")
fc1 <- mx.symbol.FullyConnected(data, name="fc1", num_hidden=3)
act1 <- mx.symbol.Activation(fc1, name="sigmoid1", act_type="sigmoid")
fc2 <- mx.symbol.FullyConnected(act1, name="fc2", num_hidden=2)
softmax <- mx.symbol.SoftmaxOutput(fc2, name="sm")

mx.set.seed(0)
model = mx.model.FeedForward.create(softmax, X = Train.X, y = Train.Y,
                                    ctx = mx.cpu(), num.round = 100, array.batch.size = 10,
                                    learning.rate = 0.05, momentum = 0.5,
                                    eval.metric = mx.metric.accuracy,
                                    epoch.end.callback = mx.callback.log.train.metric(100))
preds = predict(model, Test.X)
pred.label = max.col(t(preds)) - 1
tab = table(pred.label, Test.Y)
tab
cat("Testing accuracy rate =", sum(diag(tab))/sum(tab))

model
fc1_weight =as.array( model$arg.params$fc1_weight)
fc1_bias = as.array(model$arg.params$fc1_bias)
fc2_weight = as.array(model$arg.params$fc2_weight)
fc2_bias = as.array(model$arg.params$fc2_bias)

write.csv(fc1_weight, file = "fc1Weight.csv")
write.csv(fc2_weight, file = "fc2Weight.csv")
write.csv(fc1_bias, file = "fc1bias.csv")
write.csv(fc2_bias, file = "fc2bias.csv")

dim(fc1_weight)
length(fc1_bias)
dim(fc2_weight)
length(fc2_bias)
