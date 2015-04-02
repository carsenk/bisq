/*
 * This file is part of Bitsquare.
 *
 * Bitsquare is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bitsquare is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bitsquare. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bitsquare.trade;

import io.bitsquare.fiat.FiatAccount;
import io.bitsquare.offer.Offer;
import io.bitsquare.util.Utilities;

import org.bitcoinj.core.Coin;

import java.io.Serializable;

import java.security.PublicKey;

import javax.annotation.concurrent.Immutable;

@SuppressWarnings("WeakerAccess")
@Immutable
public class Contract implements Serializable {
    // That object is sent over the wire, so we need to take care of version compatibility.
    private static final long serialVersionUID = 1L;

    public final Offer offer;
    public final String takeOfferFeeTxID;
    public final Coin tradeAmount;
    public final String buyerAccountID;
    public final String sellerAccountID;
    public final FiatAccount buyerFiatAccount;
    public final FiatAccount sellerFiatAccount;
    public final String buyerP2PSigPubKeyAsString;
    public final String sellerP2PSigPubKeyAsString;

    public Contract(Offer offer,
                    Coin tradeAmount,
                    String takeOfferFeeTxID,
                    String buyerAccountID,
                    String sellerAccountID,
                    FiatAccount buyerFiatAccount,
                    FiatAccount sellerFiatAccount,
                    PublicKey buyerP2PSigPubKey,
                    PublicKey sellerP2PSigPubKey) {
        this.offer = offer;
        this.tradeAmount = tradeAmount;
        this.takeOfferFeeTxID = takeOfferFeeTxID;
        this.buyerAccountID = buyerAccountID;
        this.sellerAccountID = sellerAccountID;
        this.buyerFiatAccount = buyerFiatAccount;
        this.sellerFiatAccount = sellerFiatAccount;
        this.buyerP2PSigPubKeyAsString = Utilities.getHexFromPubKey(buyerP2PSigPubKey);
        this.sellerP2PSigPubKeyAsString = Utilities.getHexFromPubKey(sellerP2PSigPubKey);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "offer=" + offer +
                ", takeOfferFeeTxID='" + takeOfferFeeTxID + '\'' +
                ", tradeAmount=" + tradeAmount +
                ", buyerAccountID='" + buyerAccountID + '\'' +
                ", sellerAccountID='" + sellerAccountID + '\'' +
                ", buyerFiatAccount=" + buyerFiatAccount +
                ", sellerFiatAccount=" + sellerFiatAccount +
                ", buyerP2PSigPubKeyAsString='" + buyerP2PSigPubKeyAsString + '\'' +
                ", sellerP2PSigPubKeyAsString='" + sellerP2PSigPubKeyAsString + '\'' +
                '}';
    }
}
