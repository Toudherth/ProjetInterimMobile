package com.example.myapplication.frontend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.PaymentIntentResult;
import com.stripe.android.SetupIntentResult;
import com.stripe.android.Stripe;

import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.view.CardInputWidget;

public class CardPaymentHandler {
/*    private final Context context;
    private final Stripe stripe;
    private final String publishableKey;

    public CardPaymentHandler(Context context, String publishableKey) {
        this.context = context;
        this.publishableKey = publishableKey;
        this.stripe = new Stripe(context, publishableKey);
    }

    public void setupCardInput(CardInputWidget cardInputWidget) {
        cardInputWidget.setShouldShowPostalCode(false);
    }

    public void startCardPayment(String paymentIntentClientSecret) {
        stripe.confirmPayment((Activity) context, stripe.createPaymentData(paymentIntentClientSecret));
    }

    public void handlePaymentResult(Intent data) {
        PaymentIntentResult paymentIntentResult = stripe.getPaymentIntentResult(data);
        if (paymentIntentResult != null) {
            PaymentIntent paymentIntent = paymentIntentResult.getIntent();
            if (paymentIntent.getStatus() == PaymentIntent.Status.Succeeded) {
                // Paiement réussi
            } else if (paymentIntent.getStatus() == PaymentIntent.Status.RequiresPaymentMethod) {
                // Échec du paiement, méthode de paiement invalide
            }
        }
    }

    public void handleSetupResult(Intent data) {
        SetupIntentResult setupIntentResult = stripe.getSetupIntentResult(data);
        if (setupIntentResult != null) {
            SetupIntent setupIntent = setupIntentResult.getIntent();
            if (setupIntent.getStatus() == SetupIntent.Status.Succeeded) {
                // Configuration réussie
            } else if (setupIntent.getStatus() == SetupIntent.Status.RequiresPaymentMethod) {
                // Échec de la configuration, méthode de paiement invalide
            }
        }
    }

 */
}

